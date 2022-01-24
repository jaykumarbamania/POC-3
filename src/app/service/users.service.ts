import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/assets/model/user';

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

  public addEmployee(user:User){
    return this.http.post("http://localhost:8080/register",user,{responseType:'text' as 'json'});
  }

  public deleteUserById(id:number){
    return this.http.delete("http://localhost:8080/delete/soft/"+id,{responseType:'text' as 'json'});
  }
}
