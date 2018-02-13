CREATE TABLE `item_pedido` (
  `desconto` decimal(19,2) DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `pedido_id` bigint(20) NOT NULL,
  `produto_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pedido_id`,`produto_id`),
  KEY `FKtk55mn6d6bvl5h0no5uagi3sf` (`produto_id`),
  CONSTRAINT `FK60ym08cfoysa17wrn1swyiuda` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKtk55mn6d6bvl5h0no5uagi3sf` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
