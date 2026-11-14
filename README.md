# 📝 Lista de Tarefas

Projeto de teste simples que junta **Java**, **Python** e **CSS**:

- **Java** (`java/Tarefas.java`): gerencia as tarefas pelo terminal (listar, adicionar e concluir).
- **Python** (`python/gerar_pagina.py`): lê as tarefas e gera uma página HTML.
- **CSS** (`docs/style.css`): deixa a página bonita, com barra de progresso e animações.

As tarefas ficam salvas no arquivo `tarefas.txt`, uma por linha, no formato `status;texto` (`1` = concluída, `0` = pendente).

## 📁 Estrutura

```
lista-de-tarefas/
├── java/
│   └── Tarefas.java
├── python/
│   └── gerar_pagina.py
├── docs/
│   ├── index.html
│   └── style.css
├── tarefas.txt
└── README.md
```

## ▶️ Como usar

Pré-requisitos: Java 11+ e Python 3.

Rode os comandos a partir da pasta do projeto:

```bash
# Ver as tarefas
java java/Tarefas.java listar

# Adicionar uma tarefa
java java/Tarefas.java adicionar "Fazer o trabalho da faculdade"

# Concluir a tarefa número 3
java java/Tarefas.java concluir 3

# Gerar a página atualizada
python python/gerar_pagina.py
```

Depois é só abrir o arquivo `docs/index.html` no navegador.

## 🌐 Ver online (GitHub Pages)

1. No repositório, vá em **Settings → Pages**.
2. Em **Branch**, escolha `main` e a pasta `/docs`.
3. Clique em **Save**. Em alguns minutos a página fica disponível no link mostrado.

## 🛠️ Tecnologias

- Java
- Python
- HTML + CSS

## 📄 Licença

Projeto livre para estudo.
