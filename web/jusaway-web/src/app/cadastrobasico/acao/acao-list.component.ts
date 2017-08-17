import { AcaoService } from './acao.service';
import { Acao } from './acao';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'app-acao-list',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AcaoListComponent implements OnInit {
  acoes: Acao[] = [];

  constructor(private acaoService: AcaoService) { }

  ngOnInit(): void {
    this.acaoService.getAcoes()
      .map(acoes => this.acoes = acoes.slice(1, 5));
  }

}
