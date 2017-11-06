CREATE DATABASE IF NOT EXISTS jusawaydb DEFAULT CHARACTER SET = utf8;

USE jusawaydb;

CREATE TABLE IF NOT EXISTS acao
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS area
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS atividade
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS funcao
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS grupo
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS localtramitacao
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS procedimento
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS profissao
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS subarea
  (
     nome      VARCHAR(30) PRIMARY KEY,
     descricao VARCHAR(50)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS banco
  (
     numero     VARCHAR(10),
     nome       VARCHAR(50),
     PRIMARY KEY (numero)
  )
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS dadosbancarios
  (
     agencia       VARCHAR(20),
     contacorrente VARCHAR(30),
     banco         VARCHAR(60),
     usuario       INT,
     tipoconta     VARCHAR(15),
     operacao      VARCHAR(10),
     PRIMARY KEY (agencia, contacorrente)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS empresa
  (
     id INT NOT NULL auto_increment,
     PRIMARY KEY (id)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS usuario
  (
     id                 INT NOT NULL auto_increment,
     tipo               VARCHAR(20),
     nome               VARCHAR(50),
     email              VARCHAR(50),
     senha              VARCHAR(20),
     endereco_id        INT,
     dados_bancarios_id INT,
     data_cadastro      DATE,
     data_atualizacao   DATE,
     data_nascimento    DATE,
     sexo               VARCHAR(20),
     naturalidade       VARCHAR(50),
     nacionalidade      VARCHAR(50),
     estado_civil       VARCHAR(20),
     cpf                VARCHAR(11),
     rg                 VARCHAR(20),
     ctps               VARCHAR(30),
     oab                VARCHAR(30),
     instituicao        VARCHAR(50),
     profissao          VARCHAR(30),
     razao_social       VARCHAR(50),
     cnpj               VARCHAR(20),
     inscricao_estadual VARCHAR(50),
     responsavel        VARCHAR(50),
     PRIMARY KEY (id),
     INDEX usu_email (email),
     FOREIGN KEY (dados_bancarios_id) REFERENCES dadosbancarios(agencia, contacorrente),
     FOREIGN KEY (endereco_id) REFERENCES endereco(id)
  )
DEFAULT CHARACTER SET = utf8; 


CREATE TABLE IF NOT EXISTS endereco
  (
    id          INT NOT NULL auto_increment,
    usuario_id  INT,
    empresa_id  INT,
    rua         VARCHAR(50),
    numero      VARCHAR(5),
    bairro      VARCHAR(30),
    complemento VARCHAR(30),
    cep         VARCHAR(8),
    cidade      VARCHAR(30),
    uf          VARCHAR(2), 
    PRIMARY KEY (id),
    INDEX usu_end (usuario_id),
    INDEX emp_end (empresa_id)
  )
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS telefone
  (
     numero     VARCHAR(15),
     usuario_id INT,
     empresa_id INT,
     INDEX tel_usu (usuario_id),
     INDEX tel_emp (empresa_id)
  )
DEFAULT CHARACTER SET = utf8; 

