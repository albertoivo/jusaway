import { AcaoService } from './acao.service';
import { Acao } from './acao';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'app-acao-list',
  templateUrl: 'acao-list.component.html',
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
