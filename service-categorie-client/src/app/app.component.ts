import { KeycloakSecurityService } from './services/keycloak-security.service';
import { Component, OnInit } from '@angular/core';
import { error } from '@angular/compiler/src/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'service-categorie-client';

  constructor(public securityService:KeycloakSecurityService,private route:Router){}

  ngOnInit(): void {
  }

  onLogout(){
    this.securityService.kc.logout();
    
    this.route.navigateByUrl("/")
  }

  onLogin(){
    this.securityService.kc.login();
  }

  onChangepassword(){
    this.securityService.kc.accountManagement();
  }

  isAppManager(){
    return this.securityService.kc.hasRealmRole("app-manager");
  }

}
