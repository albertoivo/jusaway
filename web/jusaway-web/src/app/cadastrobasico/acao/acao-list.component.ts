import { AcaoService } from './acao.service';
import { Acao } from './acao';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'app-acao-list',
  template: `
    <div>
      <a *ngFor="let acao of lista">
        <div>
          <h4>{{acao.nome}}</h4>
        </div>
      </a>
    </div>
  `,
  styleUrls: ['../../app.component.css']
})

export class AcaoListComponent implements OnInit {
  lista: Acao[] = [];

  constructor(private acaoService: AcaoService) { }

  ngOnInit(): void {
    this.acaoService.getAcoes()
      .map(acoes => this.lista = acoes.slice(1, 10));
  }

}
