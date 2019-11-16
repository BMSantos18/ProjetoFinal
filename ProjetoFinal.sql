
CREATE TABLE Funcionarios (
	Id SERIAL UNIQUE,
	Nome VARCHAR (50) NOT NULL UNIQUE,
	Login VARCHAR (20) NOT NULL PRIMARY KEY,
	CPF VARCHAR (21) NOT NULL UNIQUE,
	CEP VARCHAR (12) NOT NULL,
	Senha VARCHAR (20) NOT NULL,
	Endereco VARCHAR (100) NOT NULL,
	Numero INT NOT NULL,
	Complemento VARCHAR (50) NOT NULL,
	Bairro VARCHAR (220) NOT NULL,	
	Cargo VARCHAR (50) NOT NULL,
	Salario FLOAT NOT NULL,
	Telefone1 VARCHAR (21) NOT NULL CHECK (Telefone1 != '()-'),
	Telefone2 VARCHAR (21));

	

--INSERINDO REGISTROS
	 
INSERT INTO Funcionarios (Nome, Login, CPF, CEP, Senha, Endereco, Numero, Complemento, Bairro, Cargo, Salario, Telefone1, Telefone2) VALUES 
	('admin',
	'admin',
	'admin',
	'admin',
	'master',
	'admin',
	1,
	'admin',
	'admin',
	'admin',
	1,
	'admin',
	'admin');

-- TABELA GERENTE

CREATE TABLE Gerente(
Nome VARCHAR (50) NOT NULL UNIQUE
	
)inherits(Funcionarios);


-- TABELA INATIVOS
CREATE TABLE Inativos (
	Id SERIAL PRIMARY KEY,
	Nome VARCHAR (50), 
	Login VARCHAR (20) ,
	CPF VARCHAR (21),
	CEP VARCHAR (12),
	Senha VARCHAR (20),
	Endereco VARCHAR (50),
	Numero INT NOT NULL,
	Complemento VARCHAR (50),
	Bairro VARCHAR (220),	
	Cargo VARCHAR (50),
	Salario FLOAT,
	Telefone1 VARCHAR (21),
	Telefone2 VARCHAR (21),
	data_Demi DATE);
	
--TABELA ESTOQUE -> Produto

	CREATE TABLE Produto ( --Mudar nome da tabela para Produto (Era Estoque)
	Id SERIAL PRIMARY KEY,
	Nome VARCHAR (50) NOT NULL UNIQUE,
	Preco FLOAT (10) NOT NULL CHECK (Preco>0),
	Quantidade INT NOT NULL CHECK (Quantidade>0),
	Marca VARCHAR (50) NOT NULL, -- Era Fornecedor
	FuncionarioSoli varchar (50) REFERENCES Funcionarios (Nome),
	Supervisor varchar(50) REFERENCES Gerente (Nome)
	);

-- INSERINDO REGISTROS

INSERT INTO Produto (Nome, Preco, Marca, Quantidade) VALUES 
        ('Placa de Video',
	200,
	'EVGA',
	15
	);

--TABELA HISTÓRICO DE VENDAS 

CREATE TABLE HistoricoDeVendas (
	Id SERIAL PRIMARY KEY,
	NomeFuncionario VARCHAR (50) REFERENCES Funcionarios (Nome),
	PrecoTotal FLOAT (10) NOT NULL CHECK (PrecoTotal > 0), -- Pegar da tela do Caixa
	Produto VARCHAR (50) NOT NULL REFERENCES Produto(Nome), -- Era Produtos
	QuantidadeDeProduto INT CHECK (QuantidadeDeProduto > 0), -- Era QuantidadeDeProdutos
	Data_venda VARCHAR (15)
	);

-- INSERINDO REGISTROS

	INSERT INTO HistoricoDeVendas (NomeFuncionario, PrecoTotal, Produto, QuantidadeDeProduto,Data_venda ) VALUES 
        ('admin',
        5,
        'Placa de Video',
        1,
        '06/11/2019'
	);


-- TABELA REGISTRO DE COMPRAS
	CREATE TABLE RegistroCompra( -- Inserir na tabela Produto e na tabela HistoricoDeCompras
	Id serial PRIMARY KEY,
	NomeProduto VARCHAR (50) NOT NULL,
	ValorTotal FLOAT CHECK (ValorTotal > 0),
	ValorUnitario FLOAT NOT NULL CHECK (ValorUnitario > 0),
	Quant INT NOT NULL CHECK (Quant > 0),
	Solicitante VARCHAR (50) REFERENCES Funcionarios (Login),
	Aprovacao VARCHAR (50) REFERENCES Gerente (Nome),
	Data_Compra VARCHAR (15) 
	);


-- TABELA ACESSO

	CREATE TABLE ACESSO(
	Id SERIAL PRIMARY KEY,
	Login varchar(15) REFERENCES Funcionarios(Login),
	dataAcesso varchar (15),
	horaAcesso varchar (15) 
	);


CREATE TABLE tempo (
	Id SERIAL PRIMARY KEY,
	Nome VARCHAR (50) NOT NULL REFERENCES Produto(Nome), 
	Preco FLOAT (10) NOT NULL,
	Quantidade INT NOT NULL
	);



SELECT * FROM Funcionarios;
SELECT * FROM Gerente;
SELECT * FROM Inativos;
SELECT * FROM Produto;
SELECT * FROM HistoricoDeVendas;
SELECT * FROM RegistroCompra;
SELECT * FROM ACESSO;
SELECT * FROM tempo;

SELECT * FROM ProjetoFinal;


DROP TABLE Funcionarios;
DROP TABLE Gerente;
DROP TABLE Produto;
DROP TABLE Inativos;
DROP TABLE HistoricoDeVendas;
DROP TABLE RegistroCompra;
DROP TABLE ACESSO;
DROP TABLE tempo;