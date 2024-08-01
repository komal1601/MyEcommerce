import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {


  signupForm!:FormGroup;
  hidePassword = true;

  constructor(
    private fb: FormBuilder,
    private authService : AuthService,
    private snackBar: MatSnackBar,
    private router : Router  )
  {
    
  }
  
ngOnInit() : void {

  this.signupForm = this.fb.group({
    name: [null, [Validators.required]],
    email: [null, [Validators.required]],
    password: [null, [Validators.required]],
    confirmPassword: [null, [Validators.required]],
})
   
    }

   togglePasswordvisibility(){
    this.hidePassword  = !this.hidePassword;
   }

   onSubmit(): void{

   const password = this.signupForm.get('password')?.value;
   const confirmPassword = this.signupForm.get('confirmPassword')?.value;

   if(password !== confirmPassword){
    this.snackBar.open('passwords do not match.', 'close', { duration : 5000, panelClass: 'error-snackbar'});
     return; 
  }

  this.authService.register(this.signupForm.value).subscribe(
(response) => {
  this.snackBar.Open('sign up successful...!!', 'close', {duration : 5000});
  this.router.navigateByUrl("/login");

},

(error)=> {
  this.snackBar.open('sign up failed.  Please Try Again..!!', 'close', {duration: 5000, panelclass : 
    'error-snackBar'
  });
}

  )
   }
 }


