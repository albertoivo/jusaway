import { Http, Response, RequestOptions, ResponseOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Acao } from './acao';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AcaoService {

    private headers = new Headers({ 'Content-Type': 'application/json' });
    private options = new ResponseOptions({ headers: this.headers });

    private acoesUrl = 'http://localhost:8080/acoes';

    constructor(private http: Http) { }

    getAcoes(): Promise<Acao[]> {
        return this.http.get(this.acoesUrl, this.options)
            .toPromise()
            .then(response => response.json().data as Acao[])
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('Erro ao recuperar as Ações!', error);
        return Promise.reject(error.message || error);
    }

}
