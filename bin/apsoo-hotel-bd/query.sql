-- CRIAÇÃO DO SCHEMA HOTEL

--CREATE SCHEMA hotel;

-- CRIAÇÃO DAS TABELAS

CREATE TABLE pessoa (
    cpf varchar (11) NOT NULL PRIMARY KEY,
    pes_end integer NOT NULL,
    nome varchar (255) NOT NULL,
    dataNasc date,
    telefone varchar(15),
    foreign key (pes_end) references endereco(idEnd)    
);

CREATE TABLE funcionario (
    fcpf varchar (11) NOT NULL primary key,
    login varchar (255) NOT NULL,
    senha varchar (15) NOT NULL,
    salario decimal (10) NOT NULL,
    cargo varchar (255) NOT NULL,
    FOREIGN KEY (fcpf) REFERENCES pessoa(cpf)
);

CREATE TABLE hospede (
    hcpf varchar (11) NOT NULL primary key,
    hos_res integer NOT NULL,
    sexo char (1),
    codigoConta integer NOT NULL,
    FOREIGN KEY (hcpf) REFERENCES pessoa(cpf),
    FOREIGN KEY (hos_res) REFERENCES reserva(idRes)
);

CREATE TABLE p_telefone (
	pcpf varchar (255) NOT NULL primary key,
    num_telefone varchar (11),
    FOREIGN KEY (pcpf) REFERENCES pessoa(cpf)
);

CREATE TABLE reserva (
	idRes integer NOT NULL primary key,
    fcpf varchar (255) NOT NULL,
    dataInicial date,
    dataFinal date,
    pagamento varchar (255),
    FOREIGN KEY (fcpf) REFERENCES funcionario (fcpf)
    
);

CREATE TABLE reservaQuarto (
	idRes integer NOT NULL,
    codigoQuarto integer NOT NULL primary key,
    FOREIGN KEY (idRes) REFERENCES reserva(idRes),
    FOREIGN KEY (codigoQuarto) REFERENCES quarto(codigoQuarto)
);

CREATE TABLE quarto (
	codigoQuarto integer NOT NULL primary key,
    qua_tip_quarto qua_tip_quarto integer NOT NULL,
    qua_hospedagem integer NOT NULL,
    localizao varchar (255),
    sitacao varchar (255),
    FOREIGN KEY (qua_hospedagem) REFERENCES hospedagem(idHospedagem),
    FOREIGN KEY (qua_tip_quarto) REFERENCES tipoDeQuarto(idTipQuarto)
);

CREATE TABLE hospedagem (
	idHospedagem integer NOT NULL primary key,
    hos_res integer NOT NULL,
    fcpf varchar (11) NOT NULL,
    hcpf varchar (11) NOT NULL,
    hdata date,
    horario time,
    FOREIGN KEY (fcpf) REFERENCES funcionario(fcpf),
    FOREIGN KEY (hos_res) REFERENCES reserva(idRes),
    FOREIGN KEY (hcpf) REFERENCES hospede(hcpf)
);

CREATE TABLE endereco (
	idEnd integer NOT NULL primary key,
    rua varchar (255),
    numero integer (4),
    bairro varchar (255),
    cep varchar (8) NOT NULL,
    cidade varchar (255),
    esado char (2),
    complemento varchar (500)
);

CREATE TABLE tipoDeQuarto (
	idTipQuarto integer NOT NULL primary key,
    valor integer,
    descricao varchar (500)
);

CREATE TABLE itemServico (
	item_ser_hospedagem integer NOT NULL,
    idTipSer integer NOT NULL primary key,
    tipo varchar (255),
    valor integer,
    descricao varchar (255),
    FOREIGN KEY (item_ser_hospedagem) REFERENCES hospedagem(idHospedagem)
);

CREATE TABLE servico (
	codigo integer NOT NULL primary key,
    ser_tip_ser integer NOT NULL,
    FOREIGN KEY (ser_tip_ser) REFERENCES itemServico(idTipSer )
);
