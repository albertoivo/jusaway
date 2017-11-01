CREATE DATABASE IF NOT EXISTS jusawaydb DEFAULT CHARACTER SET = utf8;

USE jusawaydb;

CREATE TABLE IF NOT EXISTS acao (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS area (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS atividade (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS funcao (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS grupo (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS localtramitacao (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS procedimento (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS profissao (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS subarea (nome varchar(30) primary key, descricao varchar(50)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS banco (numero varchar(15) primary key, nome varchar(30)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS dadosbancarios (banco_numero varchar(15) not null, usuario int, agencia varchar(20), contacorrente varchar(30), tipoconta varchar(15), operacao varchar(10), PRIMARY KEY (id), foreign key (banco_numero) references banco(numero)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS endereco (usuario int, rua varchar(50), numero varchar(5), bairro varchar(30), complemento varchar(30), cep varchar(8), cidade varchar(30), uf varchar(2), PRIMARY KEY (rua, numero)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS usuario (id INT NOT NULL AUTO_INCREMENT, tipo varchar(20), nome varchar(50), email varchar(50), senha varchar(20), endereco_id INT, dados_bancarios_id INT, data_cadastro date, data_atualizacao date, data_nascimento date, sexo varchar(20), naturalidade varchar(50), nacionalidade varchar(50), estado_civil varchar(20), cpf varchar(11), rg varchar(20), ctps varchar(30), oab varchar(30), instituicao varchar(50), profissao varchar(30), razaoSocial varchar(50), cnpj varchar(20), inscricaoEstadual varchar(50), responsavel varchar(50), primary key (id), foreign key (dados_bancarios_id) references dadosbancarios(id), foreign key (endereco_id) references endereco(id)) DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS telefone (ddd varchar(3), numero varchar(10), usuario int, primary key (ddd, numero), foreign key (usuario) references usuario(id)) DEFAULT CHARACTER SET = utf8;
