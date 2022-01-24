import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-editform',
  templateUrl: './editform.component.html',
  styleUrls: ['./editform.component.css']
})
export class EditformComponent implements OnInit {

  constructor(
    private activatedRoute:ActivatedRoute,
    private userService:UsersService
  ) { }

  user: any;
  id:any;


  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params:ParamMap) =>{
      let str_id = parseInt(params.get('id'));
      this.id = str_id;
    })
    this.userService.getUserById(this.id)
    .subscribe((data) => this.user = data)
  }

}
