import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import { EditformComponent } from './editform/editform.component';
import { ShowusersComponent } from './showusers/showusers.component';

const routes: Routes = [
  {path:"", redirectTo:"users",pathMatch:"full"},
  {path:"adduser",component:AddUserComponent},
  {path:"users",component:ShowusersComponent},
  {path:"edit/:id",component:EditformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
