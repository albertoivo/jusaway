import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './cadastrobasico.component.html',
  styleUrls: ['../app.component.css']
})

// Obrigatório o Component com o nome do arquivo para usar no app-routing
export class CadastrobasicoComponent {
  title = 'Dashboard';
}

export class AcaoComponent {
  title = 'Ação';
  nome: string;
  descricao: string;
}

export class AreaComponent {
  title = 'Área';
  nome: string;
  descricao: string;
}
