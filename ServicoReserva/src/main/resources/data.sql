CREATE TABLE Cartao (
    id SERIAL PRIMARY KEY,
    cvc VARCHAR(100),
    nome VARCHAR(100),
    numero VARCHAR(100) UNIQUE,
    dataValidade VARCHAR(100)
);

CREATE TABLE Usuario (
    email VARCHAR(100) PRIMARY KEY,
    nome VARCHAR(100),
    senha VARCHAR(100),
    cartao VARCHAR(100) REFERENCES Cartao(id)
);

CREATE TABLE Locadora (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    descricao VARCHAR(100),
    localizacao VARCHAR(100)
);

CREATE TABLE Car (
    modelo VARCHAR(100),
    placa VARCHAR(100) PRIMARY KEY,
    preco NUMERIC(10, 2),
    ano INTEGER,
    combustivel VARCHAR(100),
    transmissao VARCHAR(100),
    linkFotos VARCHAR(100),
    locadora INTEGER REFERENCES Locadora(id)
);

CREATE TABLE Reserva (
    placa VARCHAR(100) REFERENCES Car(placa),
    valor NUMERIC(10, 2),
    id SERIAL PRIMARY KEY,
    taxa INTEGER,
    dataInicio DATE,
    dataTermino DATE,
    usuario VARCHAR(100) REFERENCES Usuario(email)
);

-- Inserir dados na tabela Cartao
INSERT INTO Cartao (cvc, nome, numero, dataValidade) VALUES
  ('123', 'João da Silva', '1111222233334444', '12/25'),
  ('456', 'Maria Oliveira', '5555666677778888', '06/24'),
  ('789', 'Carlos Santos', '9999888877776666', '09/23'),
  ('321', 'Ana Pereira', '1234123412341234', '03/22');

-- Inserir dados na tabela Locadora
INSERT INTO Locadora (nome, descricao, localizacao) VALUES
  ('Locadora A', 'Oferecemos carros de luxo', 'Rua Principal, 123'),
  ('Locadora B', 'Variedade de veículos econômicos', 'Avenida Secundária, 456'),
  ('Locadora C', 'Carros familiares e espaçosos', 'Travessa da Praça, 789'),
  ('Locadora D', 'Veículos para aventuras off-road', 'Rua da Montanha, 101');

-- Inserir dados na tabela Car
INSERT INTO Car (modelo, placa, preco, ano, combustivel, transmissao, linkFotos, locadora) VALUES
  ('Toyota Corolla', 'ABC1234', 200.00, 2020, 'Gasolina', 'Automatica', 'https://t.ctcdn.com.br/TTK4snJlPOGKuXIB29QtvxjaT0U=/1200x675/smart/i635860.jpeg', 1),
  ('Volkswagen Gol', 'DEF5678', 150.00, 2018, 'Etanol', 'Manual', 'https://cdn.motor1.com/images/mgl/gRAz7/s1/vw-gol-2017.jpg', 2),
  ('Chevrolet Spin', 'GHI9012', 180.00, 2019, 'Flex', 'Automatica', 'https://cdn.motor1.com/images/mgl/y2PR7G/s3/projecao-chevrolet-spin-2025---tudo-de-carro.jpg', 3),
  ('Jeep Wrangler', 'JKL3456', 250.00, 2022, 'Diesel', 'Manual', 'https://destaquejeep.com.br/wp-content/uploads/2019/12/mini-wrangler.jpg.webp', 4);

-- Inserir dados na tabela Usuario
INSERT INTO Usuario (email, nome, senha, cartao) VALUES
  ('joao@email.com', 'João da Silva', 'senha123', 1),
  ('maria@email.com', 'Maria Oliveira', 'senha456', 2),
  ('carlos@email.com', 'Carlos Santos', 'senha789', 3),
  ('ana@email.com', 'Ana Pereira', 'senha321', 4);

-- Inserir dados na tabela Reserva
INSERT INTO Reserva (placa, valor, taxa, dataInicio, dataTermino, usuario) VALUES
  ('ABC1234', 300.00, 10, '2023-01-01', '2023-01-10', 'joao@email.com'),
  ('DEF5678', 250.00, 15, '2023-02-01', '2023-02-15', 'maria@email.com'),
  ('GHI9012', 180.00, 8, '2023-03-01', '2023-03-10', 'carlos@email.com'),
  ('JKL3456', 250.00, 12, '2023-04-01', '2023-04-15', 'ana@email.com');
