import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http:HttpClient) { }

  public getAllUsers(){
    return this.http.get("http://localhost:8080/users");
  }

  public getUserById(id:number){
    return this.http.get("http://localhost:8080/user/"+id)
  }


}
