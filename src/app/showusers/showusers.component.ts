import { Component, OnInit } from '@angular/core';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-showusers',
  templateUrl: './showusers.component.html',
  styleUrls: ['./showusers.component.css']
})
export class ShowusersComponent implements OnInit {

  constructor(private userService:UsersService) { }

  users:any;
  msg:any;

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){
    this.userService.getAllUsers()
    .subscribe((data) => this.users = data)
  }

  deleteUser(id:number,index:number){
    this.userService.deleteUserById(id)
    .subscribe((data) => {
      this.msg = data;
      this.users.splice(index,1)
    })
  }

}
