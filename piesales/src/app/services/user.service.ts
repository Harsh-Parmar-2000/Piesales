import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import gatewayUrl from './helper';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public loginStatusSubject = new Subject<boolean>();
  constructor(private http: HttpClient) {

  }

  public registerUser(user:any){
    return this.http.post(`http://localhost:9091/auth/api/register`,user);
  }

  public login(user:any){
    return this.http.post(`http://localhost:9091/auth/api/login`,user);
  }

  public getCurrentUser() {
    return this.http.get(`http://localhost:9091/auth/api/logineduser`);
  }

  public setTokenToLocalStorage(token:any){
    localStorage.setItem('token',token);
    return true;
  }

  public isLoggedIn(){
    let tokenStr = localStorage.getItem('token');
    if(tokenStr==undefined || tokenStr==null || tokenStr == ''){
      return false;
    }
    else{
      return true;
    }
  }

  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  public setUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));
  }

  public getUser(){
    let user = localStorage.getItem('user');
    if(user != null){
      return JSON.parse(user);
    }
      this.logout();
      return null;
  }

  public getUserRole(){
    let user = this.getUser();
    return user.authorities[0].authority;
  }

  public getToken() {
    return localStorage.getItem('token');
  }
}
