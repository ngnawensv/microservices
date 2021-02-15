import { KeycloakSecurityService } from './keycloak-security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  constructor(private http:HttpClient, private securityService:KeycloakSecurityService) { }

    /**
     * Au lieu de transporter le headers sur chaque requete http, il est preferable de créer
     * un intercepteur
     */
  public getArticles(){
    //Gestion de la securité en ajoutant le headers sans intercepeur de requete
    /* return this.http.get("http://localhost:8082/articles",
    {headers:new HttpHeaders({Authorization:'Bearer '+this.securityService.kc.token})}); */
    
    //Utilistion d'intercepteur de requete. A chaque emission d'une requete, l'intercepteur ajoute le headers
    return this.http.get("http://localhost:8082/articles");
  }
}
