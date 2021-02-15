import { KeycloakSecurityService } from './services/keycloak-security.service';
import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategorieComponent } from './categorie/categorie.component';
import { ArticleComponent } from './article/article.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RequestInterceptorService } from './services/request-interceptor.service';

export function kcFactory(kcSecurity:KeycloakSecurityService){
  return ()=>kcSecurity.init();
}

@NgModule({
  declarations: [
    AppComponent,
    CategorieComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule 
  ],
  providers: [
    //Demarre au chargement de l'application
    {provide:APP_INITIALIZER,deps:[KeycloakSecurityService],useFactory:kcFactory,multi:true},
    //Intervien à chaque emission d'une requetes
    {provide:HTTP_INTERCEPTORS,useClass:RequestInterceptorService,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
