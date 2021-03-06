/**
 * Created by camilosampedro on 1/01/17.
 */
import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Router} from '@angular/router';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Response} from '@angular/http';

@Injectable()
export class LoginService {
    private loggedIn = false;

    constructor(private http: Http, private router: Router) {
        this.loggedIn = !!localStorage.getItem('auth_token');
    }

    login(username: string, password: string) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');

        return this.http
            .post(
                '/api/login',
                JSON.stringify({username, password}),
                {headers}
            ).map(res=>{
                if(res.status==200){
                    localStorage.setItem('auth_token',"ok");
                } else {
                    localStorage.removeItem('auth_token')
                }
                res.json()
            })

    }

    logout() {
        LoginService.deleteToken();
        return this.http
            .get('/api/logout')
            .map(res => res.json())
    }

    static isLoggedIn() {
        return localStorage.getItem('auth_token') != null;
    }

    static deleteToken() {
        localStorage.removeItem('auth_token');
        console.log('token deleted');
    }
}