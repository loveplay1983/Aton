package services.impl

import com.google.inject.{Inject, Singleton}
import dao.ComputerDAO
import model.{Computer, ComputerState, ConnectedUser}
import services.{ComputerService, SSHOrderService}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by camilo on 14/05/16.
  */
@Singleton
class ComputerServiceImpl @Inject()(sSHOrderService: SSHOrderService, computerDAO: ComputerDAO)(implicit executionContext: ExecutionContext) extends ComputerService {

  override def add(computer: Computer): Future[String] = {
    play.Logger.debug("Adding computer")
    computerDAO.add(computer)
  }

  override def edit(computer: Computer): Future[Int] = {
    play.Logger.debug("Editing computer")
    computerDAO.edit(computer)
  }

  override def listAll: Future[Seq[(Computer, Option[(ComputerState, Seq[ConnectedUser])])]] = {

    computerDAO.listAll.map(computers =>

      computers
        // Grouping by the computer
        .groupBy(_._1)

        .map { groupedComputer =>
          (groupedComputer._1, groupedComputer._2.map { computerStateWithUsers =>
            (computerStateWithUsers._2, computerStateWithUsers._3)
          }.groupBy(_._1).map { groupedState =>
            (groupedState._1, groupedState._2.flatMap(_._2))
          }.flatMap {
            case (Some(computerstate), users) => Some((computerstate, users))
            case _ => None
          }.toSeq.sortBy(_._1.registeredDate.getTime).headOption)
        }.toSeq.sortBy(_._1.ip)
    )
  }

  override def listAllSimple: Future[Seq[Computer]] = {
    computerDAO.listAllSimple.map(computers => computers.sortBy(_.ip))
  }
}
