import './rxjs-extensions';

import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { NgSemanticModule } from 'ng-semantic';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent }         from './app.component';
import {LoginComponent} from './login/login.component';
import {APP_BASE_HREF}          from '@angular/common';
import {MenuComponent} from "./menu/menu.component";
import {ComputerComponent} from "./computer/computer.component";
import {RoomComponent} from "./room/room.component";
import {LaboratoryComponent} from "./laboratory/laboratory.component";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    NgSemanticModule
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    ComputerComponent,
    RoomComponent,
    LaboratoryComponent
  ],
  providers: [ {provide: APP_BASE_HREF, useValue: '/'} ],
  bootstrap: [ AppComponent ],
})
export class AppModule { }

/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
