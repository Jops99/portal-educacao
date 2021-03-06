<?php
	//se for clicado botão excluir
	include('cabecalho.html');
	if(isset($_POST['excluir-alterar'])){
	    //Pega os dados via POST.
		$id = $_POST['formID'];
		
		//Conectando e escrevendo no BD
	   	$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
	   	$sql = "DELETE FROM questoes WHERE id=\"".$id."\"";
	   	
	   	if($conexao->exec($sql)){
		  	$msg = "Questão apagada com sucesso!";
		}else{
		 	$msg = "Questão não apagada!";
		}
		
		//Apaga possiveis imagens
		unlink("uploads/".$id.'.jpg');
		unlink("uploads/".$id.'.jpeg');
		unlink("uploads/".$id.'.gif');
		unlink("uploads/".$id.'.png');
		
		//Exibe estado da operação ao usuario			
		echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
			<a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i></a>
			</div><br><br>";
	
		include('rodape.html');	
	}
	//Se for clicado botão enviar
	else{
		//Pega os dados via POST.
		$id = $_POST['formID'];
		$estilo = $_POST['estilo-alterar'];
		$nivel = $_POST['nivel-alterar'];
		$disciplina = $_POST['disciplina-alterar'];
	   $tema = $_POST['tema-alterar'];
	   $cabecalho = $_POST['cabecalho-alterar'];
	   $criador = $_SERVER['SERVER_ADMIN'];
	   $qNumero = $_POST['numQuestao'];
   	 
	   	//Se o estilo da questao selecionada for ME.
	   	if($estilo==0){    	
	   		//Gera o XML correspondenete a questao.
	   	 	$GLOBALS['xml'] = "<questao tipo=\"ME\" aleatorio=\"true\">
	   	 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
	   	     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
	   	     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
	   	     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
   	     		
	   	    //Pegando as alternativas em Array.
	   	 	$alternativa = array();
	   	 	$radio = $_POST['rdioEdit-'.$qNumero];
	   	 	for($i=0; $i<=4; $i++){ //Trocar para for..of!
				if(array_key_exists('alternativaEdit-'.$qNumero.'-'.$i, $_POST)){
					$alternativa[$i] = $_POST['alternativaEdit-'.$qNumero.'-'.$i];
					if('rdioEdit-'.$qNumero.'-'.$i==$radio)
						$GLOBALS['xml'] .= "<alternativa correta=\"true\">".$alternativa[$i]."</alternativa>";
					else
						$GLOBALS['xml'] .= "<alternativa correta=\"false\">".$alternativa[$i]."</alternativa>";
				}		
			}
		}
		
		//Se o estilo da questao selecionada for VF.
	    if($estilo==1){    	
	   	 	//Gera o XML correspondenete a questao.
	   	 	$GLOBALS['xml'] = "<questao tipo=\"VF\" aleatorio=\"true\">
	   	 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
	   	     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
	   	     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
	   	     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
	   	     		
	   	    //Pegando as alternativas em Array.
	   	 	$alternativa = array();
	   	 	for($i=0; $i<=4; $i++){
				if(array_key_exists('alternativaEdit-'.$i, $_POST)){
					$alternativa[$i] = $_POST['alternativaEdit-'.$i];
					if($_POST['cBoxEdit-'.$i]=='on'){
						$GLOBALS['xml'] .= "<alternativa correta=\"true\">".$alternativa[$i]."</alternativa>";
					}else{
						$GLOBALS['xml'] .= "<alternativa correta=\"false\">".$alternativa[$i]."</alternativa>";
					}
				}	
			}
		}
		
		//Se o estilo da questao selecionada for 'aberta'.
		if($estilo==2){    	
		 	//Gera o XML correspondenete a questao.
		 	$GLOBALS['xml'] = "<questao tipo=\"aberta\" aleatorio=\"true\">
		 			<dificuldade>".$GLOBALS['nivel']."</dificuldade> <!--dificuldade(1 a 3) -->
		     		<materia>".$GLOBALS['disciplina']."</materia> <!--Materia -->
		     		<conteudo>".$GLOBALS['tema']."</conteudo> <!--Conteudo -->
		     		<enunciado>".$GLOBALS['cabecalho']."</enunciado> <!--enunciado -->";
		}
	
   	    //Conecta e escreve no banco de dados.
   	 	$conexao = new PDO('mysql:host=localhost; dbname=banco_de_questoes', 'phpmyadmin', 'o9rtjh88');    
   		$sql = "UPDATE questoes SET Materia='".$disciplina."', Conteudo='".$tema."', Dificuldade='".$nivel."', Tipo='".$estilo."', WHERE id='".$id."'";
		
		if($conexao->exec($sql)){
			$msg = "Questão salva.";
		}else{
			$msg = "Questão salva!";
		}
		
		//Altera possivel imagem
		if(isset($_FILES['alteraImagem']['name'])&&$_FILES['alteraImagem']['error']==0){
			$arquivo_tmp = $_FILES['alteraImagem']['tmp_name'];
			$nome = $_FILES['alteraImagem']['name'];
			
			$extensao = pathinfo($nome, PATHINFO_EXTENSION);
			$entensao = strtolower($extensao);
			if(strstr('.jpg;.jpeg;.gif;.png', $extensao)){
				$novoNome = $id.'.'.$extensao;
				$destino = 'uploads/'.$novoNome;
				
				if(file_exists("uploads/".$id.'.jpg')) unlink("uploads/".$id.'.jpg');
				else if(file_exists("uploads/".$id.'.jpeg')) unlink("uploads/".$id.'.jpeg');
				else if(file_exists("uploads/".$id.'.gif')) unlink("uploads/".$id.'.gif');
				else if(file_exists("uploads/".$id.'.png')) unlink("uploads/".$id.'.png');
				
				move_uploaded_file($arquivo_tmp, $destino);
				$msg .="<br>Imagem alterada.";
				$GLOBALS['xml'] .= "<imagem>\"".$destino."\"</imagem>";
			} else $msg .= "<br>Imagem não alterada.";
		}
		//Exclui a imagem porém mantendo a questao
		else{
			if($_POST['excluido-'.$_POST['numQuestao']]==true){
					unlink("uploads/".$id.'.jpg');
					unlink("uploads/".$id.'.jpeg');
					unlink("uploads/".$id.'.gif');
					unlink("uploads/".$id.'.png');
					$msg .= "<br>Imagem Excluida.";
			}
		}
		
		//fecha o XML
		$GLOBALS['xml'] .= "</questao>";
		
		//Atualiza o XML para conter ou não caminho da nova imagem
		$sql = "UPDATE questoes SET XML='".$GLOBALS['xml']."' WHERE ID='".$id."'";
		$conexao->exec($sql);
		echo "<div class=\"row center\"><h5 class=\"header col s12 light\">".$msg."</h5><br><br>
			<a class=\"waves-effect waves-light btn light-blue darken-4\" href=\"BancoDeQuestoes.php\"
			id=\"inserir\">Voltar<i class=\"tiny material-icons white-text text-darken-1\">replay</i></a>
			</div><br><br>";
			
		include('rodape.html');
	}
?>
