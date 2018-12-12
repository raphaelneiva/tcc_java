-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Dez-2018 às 19:29
-- Versão do servidor: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(40) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `nome`, `email`, `telefone`, `status`) VALUES
(1, 'João Ricardo', 'jricardo@gmail.com', '90', '8 - muito interessado'),
(2, 'Pedro Alberto', 'alberto@gmail.com', '61990001', '8 - muito interessado'),
(3, 'Rafael Silva', 'rafaelsilva@gmail.com', '61900123123', '5 - indeciso '),
(4, 'Maria de Freitas', 'maria@gmail.com', '61921277778', '6 - disposta '),
(5, 'Marcelina Nunes', 'mnunes@gmail.com', '6190123123', '8 - muito interessado'),
(6, 'Ronaldo de Assiss Moreira', 'ronaldinho@gmail.com', '61988888888', '8 - muito interessado'),
(7, 'José Silva', 'jalberto@gmail.com', '61988110234', 'muito interessado'),
(8, 'João Pereira Ribeiro', 'rei@gmail.com', '6190021212', '6 - Aluno compareceu a aula'),
(9, 'Juliana da Costa Neto', 'julia33@gmail.com', '96111212', '4 - Pagamento confirmado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `nome`, `preco`) VALUES
(1, 'Culinária Asiática Introdução', 500),
(2, 'Sobremesas Casuais', 300);

-- --------------------------------------------------------

--
-- Estrutura da tabela `etiqueta`
--

CREATE TABLE `etiqueta` (
  `id_aluno` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `etiqueta`
--

INSERT INTO `etiqueta` (`id_aluno`, `id_curso`, `id`, `nome`) VALUES
(6, 1, 2, 'aa'),
(4, 2, 4, 'ee2'),
(4, 1, 5, 'aa4');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(40) NOT NULL,
  `id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `login`, `senha`, `endereco`, `telefone`, `id_perfil`) VALUES
(1, 'Admin', 'admin', '123', 'Brasilia', '6190000000', 1),
(2, 'Maria Clara da Silva ', 'mclara', '123', 'Asa Norte 712', '61981110202', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `matricularaluno`
--

CREATE TABLE `matricularaluno` (
  `id_turma` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `matricularaluno`
--

INSERT INTO `matricularaluno` (`id_turma`, `id_aluno`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 6),
(2, 1),
(2, 2),
(2, 6),
(3, 4),
(3, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `icone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `menu`
--

INSERT INTO `menu` (`id`, `titulo`, `link`, `icone`) VALUES
(1, 'Home', 'index.jsp', NULL),
(2, 'Funcionário', 'listar_funcionario.jsp', 'null'),
(4, 'Curso', 'listar_curso.jsp', ''),
(5, 'Aluno', 'listar_aluno.jsp', ''),
(6, 'Turma', 'listar_turma.jsp', ''),
(7, 'Etiqueta', 'listar_etiqueta.jsp', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

CREATE TABLE `perfil` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id`, `nome`) VALUES
(1, 'Administrador'),
(2, 'Atendente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil_menu`
--

CREATE TABLE `perfil_menu` (
  `id_perfil` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `perfil_menu`
--

INSERT INTO `perfil_menu` (`id_perfil`, `id_menu`) VALUES
(1, 1),
(1, 2),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 1),
(2, 2),
(2, 4),
(2, 5),
(2, 6),
(2, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id`, `data`, `id_curso`) VALUES
(1, '2018-11-30', 1),
(2, '2018-12-08', 1),
(3, '2018-12-27', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idaluno_UNIQUE` (`id`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idcursos_UNIQUE` (`id`);

--
-- Indexes for table `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD PRIMARY KEY (`id`,`id_aluno`,`id_curso`),
  ADD UNIQUE KEY `tagcol_UNIQUE` (`id`),
  ADD KEY `fk_aluno_has_curso_curso1_idx` (`id_curso`),
  ADD KEY `fk_aluno_has_curso_aluno1_idx` (`id_aluno`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`),
  ADD KEY `fk_usuario_perfil_idx` (`id_perfil`);

--
-- Indexes for table `matricularaluno`
--
ALTER TABLE `matricularaluno`
  ADD PRIMARY KEY (`id_turma`,`id_aluno`),
  ADD KEY `fk_turma_has_aluno_aluno1_idx` (`id_aluno`),
  ADD KEY `fk_turma_has_aluno_turma1_idx` (`id_turma`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `perfil_menu`
--
ALTER TABLE `perfil_menu`
  ADD PRIMARY KEY (`id_perfil`,`id_menu`),
  ADD KEY `fk_perfil_has_menu_menu1_idx` (`id_menu`),
  ADD KEY `fk_perfil_has_menu_perfil1_idx` (`id_perfil`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idturma_UNIQUE` (`id`),
  ADD KEY `fk_turma_cursos1_idx` (`id_curso`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `etiqueta`
--
ALTER TABLE `etiqueta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `turma`
--
ALTER TABLE `turma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD CONSTRAINT `fk_aluno_has_curso_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aluno_has_curso_curso1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `matricularaluno`
--
ALTER TABLE `matricularaluno`
  ADD CONSTRAINT `fk_turma_has_aluno_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_turma_has_aluno_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `perfil_menu`
--
ALTER TABLE `perfil_menu`
  ADD CONSTRAINT `fk_perfil_has_menu_menu1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_perfil_has_menu_perfil1` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_turma_cursos1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
