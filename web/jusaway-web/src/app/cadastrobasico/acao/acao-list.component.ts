import { OnInit, Component } from '@angular/core';
import { AcaoService } from './acao.service';
import { Acao } from './acao';

@Component({
  selector: 'app-acao-list',
  templateUrl: 'acao-list.component.html',
  styleUrls: ['../../app.component.css']
})

export class AcaoListComponent implements OnInit {

  acoes: Acao[];

  constructor(private acaoService: AcaoService) { }

  getAcoes(): void {
    this.acaoService
      .getAcoes()
      .then(acoes => this.acoes = acoes);
  }

  ngOnInit(): void {
    this.getAcoes();
  }

}
