CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `instante` datetime DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `endereco_entrega_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`),
  KEY `FKcrxxe5rpllxbh0sfi4a6rwphb` (`endereco_entrega_id`),
  CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKcrxxe5rpllxbh0sfi4a6rwphb` FOREIGN KEY (`endereco_entrega_id`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pagamento` (
  `pedido_id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKthad9tkw4188hb3qo1lm5ueb0` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pagamento_boleto` (
  `data_pagamento` datetime DEFAULT NULL,
  `data_vencimento` datetime DEFAULT NULL,
  `pedido_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKdqk2a6n9it7vodk056daxe4jy` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pagamento_cartao` (
  `numero_de_parcelas` int(11) DEFAULT NULL,
  `pedido_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FK936sknk6dwq1oa3p2y7d4s8ol` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;