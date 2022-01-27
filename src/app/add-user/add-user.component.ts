import { Component, OnInit } from '@angular/core';
import { User } from 'src/assets/model/user';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user:User = new User("","","","","",new Date(),new Date());
  msg:any;

  constructor(private userService : UsersService) { }

  ngOnInit(): void {
  }

  public addUser(){
    console.log(this.user);
    let response = this.userService.addUser(this.user);

    response.subscribe((data) => this.msg = data)
  }

}

