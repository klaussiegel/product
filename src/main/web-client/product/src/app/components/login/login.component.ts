import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';
import { InfoDialogComponent } from '../info-dialog/info-dialog.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  loginForm!: FormGroup;
  infoDialogRef?: MatDialogRef<InfoDialogComponent>

  constructor(private loginService: LoginService, private router: Router, private formBuilder: FormBuilder,
     public dialog: MatDialog) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  login() {
    this.loginService.login(this.loginForm.value.userName, this.loginForm.value.password).subscribe(resp => {

      const responseMessage = resp.message;
      this.infoDialogRef = this.dialog.open(InfoDialogComponent, {
        data: {
          'title': 'Information',
          'info': responseMessage
        }
      });

      this.router.navigate(['/owner/products/']);
    },
      err => { console.log(err) },

    );
  }

}

