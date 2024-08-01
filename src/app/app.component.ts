import { Component } from '@angular/core';
import { UserStorageService } from './service/auth.service.spec';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ECommerce';

  isCustomerLoggedIn : boolean = UserStorageService.isCustomerLoggedIn();
  isAdminLoggedIn : boolean = UserStorageService.isAdminLoggedIn();

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.router.subscribe(event => {
     this.isCustomerLoggedIn = UserStorageService.isCustomerLoggedIn();
     this.isAdminLoggedIn = UserStorageService.isAdminLoggedIn();

    })
  }

  logout() {
    UserStorageService.signout();
    this.router.navigateByUrl('login');
  }
}



