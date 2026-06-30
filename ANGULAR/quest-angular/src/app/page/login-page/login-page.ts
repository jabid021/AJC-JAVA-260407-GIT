import { Component } from '@angular/core';
import { AuthRequest } from '../../model/auth-request';
import { AuthService } from '../../service/auth-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  imports: [ FormsModule ],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage {
  protected formAuth: AuthRequest = { login: "", password: "" };

  constructor(private authService: AuthService, private router: Router) { }

  public auth() {
    this.authService.auth(this.formAuth).subscribe(() => {
      this.router.navigate([ 'matiere' ]);
    });
  }
}
