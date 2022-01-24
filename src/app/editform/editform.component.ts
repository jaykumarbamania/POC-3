import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { User } from 'src/assets/model/user';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-editform',
  templateUrl: './editform.component.html',
  styleUrls: ['./editform.component.css']
})
export class EditformComponent implements OnInit {

  constructor(
    private activatedRoute:ActivatedRoute,
    private userService:UsersService,
    private router:Router
  ) { }

  user: User;
  id:any;


  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params:ParamMap) =>{
      let str_id = parseInt(params.get('id'));
      this.id = str_id;
    })
    this.userService.getUserById(this.id)
    .subscribe((data:User) => this.user = data)
  }

  updateUser(){
    this.userService.updateUser(this.user,this.id)
    .subscribe((data:User) => {
      console.log(data)
      this.user = data;
    })
    this.router.navigate(['/users']);
  }

}
