-- CRIAÇÃO DO SCHEMA HOTEL

CREATE SCHEMA hotel;

-- CRIAÇÃO DAS TABELAS

CREATE TABLE hotel.pessoa (
	cpf varchar (11) NOT NULL,
    pes_end integer NOT NULL,
    nome varchar (255) NOT NULL,
    dataNasc date
);

CREATE TABLE hotel.funcionario (
	fcpf varchar (11) NOT NULL,
    login varchar (255) NOT NULL,
    senha varchar (15) NOT NULL,
    salario decimal (10) NOT NULL,
    cargo varchar (255) NOT NULL
);

CREATE TABLE hotel.hospede (
	hcpf varchar (11) NOT NULL,
    hos_res integer NOT NULL,
    sexo char (1),
    codigoConta integer NOT NULL
);

CREATE TABLE hotel.p_telefone (
	pcpf varchar (255) NOT NULL,
    num_telefone varchar (11)
);

CREATE TABLE hotel.reserva (
	idRes integer NOT NULL,
    fcpf varchar (255) NOT NULL,
    dataInicial date,
    dataFinal date,
    pagamento varchar (255)
);

CREATE TABLE hotel.reservaQuarto (
	idRes integer NOT NULL,
    codigoQuarto integer NOT NULL
);

CREATE TABLE hotel.quarto (
	codigoQuarto integer NOT NULL,
    qua_tip_quarto qua_tip_quarto integer NOT NULL,
    qua_hospedagem integer NOT NULL,
    localizao varchar (255),
    sitacao varchar (255)
);

CREATE TABLE hotel.hospedagem (
	idHospedagem integer NOT NULL,
    hos_res integer NOT NULL,
    fcpf varchar (11) NOT NULL,
    hcpf varchar (11) NOT NULL,
    hdata date,
    horario time
);

CREATE TABLE hotel.endereco (
	idEnd integer NOT NULL,
    rua varchar (255),
    numero integer (4),
    bairro varchar (255),
    cep varchar (8) NOT NULL,
    cidade varchar (255),
    esado char (2),
    complemento varchar (500)
);

CREATE TABLE hotel.tipoDeQuarto (
	idTipQuarto integer NOT NULL,
    valor integer,
    descricao varchar (500)
);

CREATE TABLE hotel.itemServico (
	item_ser_hospedagem integer NOT NULL,
    idTipSer integer NOT NULL,
    tipo varchar (255),
    valor integer,
    descricao varchar (255)
);

CREATE TABLE hotel.servico (
	codigo integer NOT NULL,
    ser_tip_ser integer NOT NULL
);


-- SETANDO PK'S

ALTER TABLE hotel.pessoa ADD CONSTRAINT pk_cpf PRIMARY KEY (cpf);
ALTER TABLE hotel.funcionario ADD CONSTRAINT pk_fcpf PRIMARY KEY (fcpf);
ALTER TABLE hotel.endereco ADD CONSTRAINT pk_idEnd PRIMARY KEY (idEnd);
ALTER TABLE hotel.hospede ADD CONSTRAINT pk_hcpf PRIMARY KEY (hcpf);
ALTER TABLE hotel.quarto ADD CONSTRAINT pk_codigoQuarto PRIMARY KEY (codigoQuarto);
ALTER TABLE hotel.reservaQuarto ADD CONSTRAINT pk_cod_res_qua PRIMARY KEY (idRes, codigoQuarto);
ALTER TABLE hotel.reserva ADD CONSTRAINT pk_idRes PRIMARY KEY (idRes);
ALTER TABLE hotel.tipoDeQuarto ADD CONSTRAINT pk_idTipQuarto PRIMARY KEY (idTipQuarto);
ALTER TABLE hotel.hospedagem ADD CONSTRAINT pk_idHospedagem PRIMARY KEY (idHospedagem);
ALTER TABLE hotel.itemServico ADD CONSTRAINT pk_item_ser_id_rip PRIMARY KEY (item_ser_hospedagem, idTipSer);
ALTER TABLE hotel.servico ADD CONSTRAINT pk_cod PRIMARY KEY (codigo);

-- SETANDO FK'S

ALTER TABLE hotel.reserva ADD CONSTRAINT fk_reserva_funcionario FOREIGN KEY (fcpf) REFERENCES hotel.funcionario (fcpf);
ALTER TABLE hotel.p_telefone ADD CONSTRAINT fk_p_telefone_pessoa FOREIGN KEY (pcpf) REFERENCES hotel.pessoa(cpf);
ALTER TABLE hotel.hospede ADD CONSTRAINT fk_hospede_pessoa FOREIGN KEY (hcpf) REFERENCES hotel.pessoa(cpf);
ALTER TABLE hotel.hospede ADD CONSTRAINT fk_hospede_reserva FOREIGN KEY (hos_res) REFERENCES hotel.reserva(idRes);
ALTER TABLE hotel.reservaQuarto ADD CONSTRAINT fk_reservaQuarto_reserva FOREIGN KEY (idRes) REFERENCES hotel.reserva(idRes);
ALTER TABLE hotel.reservaQuarto ADD CONSTRAINT fk_reservaQuarto_quarto FOREIGN KEY (codigoQuarto) REFERENCES hotel.quarto(codigoQuarto);
ALTER TABLE hotel.funcioanrio ADD CONSTRAINT fk_funcionario_pessoa FOREIGN KEY (fcpf) REFERENCES hotel.pessoa(cpf);
ALTER TABLE hotel.hospedagem ADD CONSTRAINT fk_hospedagem_funcionario FOREIGN KEY (fcpf) REFERENCES hotel.funcionario(fcpf);
ALTER TABLE hotel.hospedagem ADD CONSTRAINT fk_hospedagem_reserva FOREIGN KEY (hos_res) REFERENCES hotel.reserva(idRes);
ALTER TABLE hotel.hospedagem ADD CONSTRAINT fk_hospedagem_hospede FOREIGN KEY (hcpf) REFERENCES hotel.hospede(hcpf);
ALTER TABLE hotel.itemServico ADD CONSTRAINT fk_itemServico_hospedagem FOREIGN KEY (item_ser_hospedagem) REFERENCES hotel.hospedagem(idHospedagem);
ALTER TABLE hotel.livro ADD CONSTRAINT fk_servico FOREIGN KEY (ser_tip_ser) REFERENCES hotel.itemServico(idTipSer );
ALTER TABLE hotel.quarto ADD CONSTRAINT fk_quarto_hospedagem FOREIGN KEY (qua_hospedagem) REFERENCES hotel.hospedagem(idHospedagem);
ALTER TABLE hotel.quarto ADD CONSTRAINT fk_quarto_tipoDeQuarto FOREIGN KEY (qua_tip_quarto) REFERENCES hotel.tipoDeQuarto(idTipQuarto);
