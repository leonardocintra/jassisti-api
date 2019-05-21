CREATE TABLE filme (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	titulo varchar(100) NOT NULL,
	the_movie_db_id INTEGER NULL,
	sinopse TEXT NULL,
	imagem_poster varchar(300) NULL,
	data_lancamento DATETIME NULL,
    PRIMARY KEY (id)
);
