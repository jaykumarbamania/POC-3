import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/assets/model/user';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-showusers',
  templateUrl: './showusers.component.html',
  styleUrls: ['./showusers.component.css']
})
export class ShowusersComponent implements OnInit {

  constructor(private userService:UsersService) { }

  users:User|any;
  msg:any;
  searchOption:string = "null";
  searchText:any = "";
  endPointUrl:any;
  inputType:string = "text";
  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){
    this.userService.getAllUsers()
    .subscribe((data:User) => this.users = data)
  }

  deleteUser(id:number,index:number){
    this.userService.deleteUserById(id)
    .subscribe((data:User) => {
      this.msg = data;
      this.users.splice(index,1)
    })
  }

  sortOnName(){
    this.userService.sortUsersByName()
    .subscribe((data:User) => {
      this.users = data;
    })
  }

  sortOnSurname(){
    this.userService.sortUsersBySurname()
    .subscribe((data:User) => {
      this.users = data;
    })
  }

  sortOnDob(){
    this.userService.sortUsersByDob()
    .subscribe((data:User) => {
      this.users = data;
    })
  }

  sortOnJoiningDate(){
    this.userService.sortUsersByJoiningDate()
    .subscribe((data:User) => {
      this.users = data;
    })
  }

  sortOnPincode(){
    this.userService.sortUsersByPincode()
    .subscribe((data:User) => {
      this.users = data;
    })
  }

  onSearch(){
    this.searchText="";
  }
  onSearchText(){
    this.endPointUrl  = this.searchOption+"/"+this.searchText;
    this.userService.searchUserBy(this.endPointUrl)
    .subscribe((data:User) => {
      this.users = data;
    })
  }
}
