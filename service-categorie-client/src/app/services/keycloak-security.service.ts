import { Injectable } from '@angular/core';
//import * as Keycloak from "keycloak-js";
import { KeycloakInstance } from 'keycloak-js';
import { any } from '../../../node_modules/codelyzer/util/function';

declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public kc: KeycloakInstance;
  public auth: any = {};

  constructor() { }

  public async init() {
    console.log("Security initialisation.... ");
    this.kc = new Keycloak({
      url: "http://localhost:8080/auth",
      realm: "stock-realm",
      clientId: "angular-service-categorie"
    });
    await this.kc.init({
      //Exiger que l'utilisateur soit authentifié avant tout exploitation de l'application
      // onLoad:'login-required'
      //laisser l'utilisateur se connecter à l'application mais s'authentifie s'il veut acceder à une ressource
      onLoad: 'check-sso'
    });
    this.auth = this.kc.tokenParsed;
    console.log(this.auth);
  }

}
