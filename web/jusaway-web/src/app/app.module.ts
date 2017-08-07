import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AlertModule } from 'ngx-bootstrap';
import { NgIf } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProcessoComponent } from './processo/processo.component';
import { ClienteComponent } from './cliente/cliente.component';
import { AdvogadoComponent } from './advogado/advogado.component';
import { CadastrobasicoComponent } from './cadastrobasico/cadastrobasico.component';
import { AcaoComponent } from './cadastrobasico/acao/acao.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    ProcessoComponent,
    DashboardComponent,
    ClienteComponent,
    AdvogadoComponent,
    CadastrobasicoComponent,
    AcaoComponent
  ],
  providers: [  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
