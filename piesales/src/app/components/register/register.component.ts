import { UserService } from './../../services/user.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private userService:UserService){

  }
  public user = {
    name:'',
    email: '',
    password:'',
    about:''
  };

  ngOnInit(){

  }

  register(){
    if(this.user.name == '' || this.user.name == null){
      alert("Name is required");
      return;
    }
    this.userService.registerUser(this.user).subscribe(
      (data)=>{

      },
      (error)=>{

      }
    )
  }
}
