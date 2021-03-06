import { HttpClient } from '@angular/common/http';
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

  constructor(private acaoService: AcaoService, private http: HttpClient) { }

  getAcoes(): void {
    this.acaoService
      .getAcoes()
      .then(acoes => this.acoes = acoes);
  }

  ngOnInit(): void {

    this.getAcoes();

    //    this.http.get('http://localhost:8080/acoes').subscribe(data => { this.acoes = data['']; });

    /*        this.acoes = [
              { nome: 'acao 1', descricao: 'desc 1' },
              { nome: 'acao 2', descricao: 'desc 2' },
              { nome: 'acao 3', descricao: 'desc 3' },
              { nome: 'acao 4', descricao: 'desc 4' }
            ];*/

  }

}
