import { KeycloakSecurityService } from './keycloak-security.service';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Ce service est un intercepteur des requetes. Sa prise en compte commence apres sa declaration
 * dans le module principale précisement dans le provides.
 */
@Injectable({
  providedIn: 'root'
})
export class RequestInterceptorService implements HttpInterceptor {

  constructor(private securityService:KeycloakSecurityService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("Request HttpInterceptor...... ")
    if(!this.securityService.kc.authenticated){
     return next.handle(req);
    }
    let request=req.clone({
      setHeaders:{
        Authorization:'Bearer '+this.securityService.kc.token
      }
    });
    return next.handle(request);
  }
}
