import { AcaoComponent } from './cadastrobasico/acao/acao.component';
import { CadastrobasicoComponent } from './cadastrobasico/cadastrobasico.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AdvogadoComponent } from './advogado/advogado.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ProcessoComponent } from './processo/processo.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },

  { path: 'advogado', component: AdvogadoComponent },
  { path: 'cliente', component: ClienteComponent },

  { path: 'processo', component: ProcessoComponent },

  { path: 'cadastroBasico', component: CadastrobasicoComponent },
  { path: 'acao', component: AcaoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
