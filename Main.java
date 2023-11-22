import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import javax.management.Query;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

      Stack<Aluno> pilhaAlunos = new Stack<>();
      Queue<Nota> filaNotas = new LinkedList<>();

      int opcao = 0;

      while (opcao != 7) {
          System.out.println("MENU");
          System.out.println("1 - Cadastrar aluno");
          System.out.println("2 - Cadastrar nota");
          System.out.println("3 - Calcular média de um aluno");
          System.out.println("4 - Listar os nomes dos alunos sem notas");
          System.out.println("5 - Excluir aluno");
          System.out.println("6 - Excluir nota");
          System.out.println("7 - Sair");

          System.out.print("Opção: ");
          opcao = sc.nextInt();

          switch (opcao) {
              case 1:
                  cadastrarAluno(pilhaAlunos);
                  break;
              case 2:
                  cadastrarNota(pilhaAlunos, filaNotas);
                  break;
              case 3:
                  calcularMediaDeAluno(pilhaAlunos, filaNotas);
                  break;
              case 4:
                  listarAlunosSemNotas(pilhaAlunos, filaNotas);
                  break;
              case 5:
                  excluirAluno(pilhaAlunos, filaNotas);
                  break;
              case 6:
                  excluirNota(filaNotas);
                  break;
              case 7:
                  System.out.println("Saindo...");
                  break;
              default:
                  System.out.println("Opção inválida!");
          }
      }
  }

  private static void cadastrarAluno(Stack<Aluno> pilhaAlunos) {
      int numero = pilhaAlunos.size() + 1;
      System.out.print("Nome do aluno: ");
      String nome = sc.next();

      Aluno aluno = new Aluno(numero, nome);
      pilhaAlunos.push(aluno);
      System.out.println("Aluno cadastrado.");
  }

  private static void cadastrarNota(Stack<Aluno> pilhaAlunos, Queue<Nota> filaNotas) {
      if (pilhaAlunos.isEmpty()) {
          System.out.println("Pilha de alunos vazia.");
          return;
      }

      System.out.print("Número do aluno: ");
      int numeroAluno = sc.nextInt();
      System.out.print("Nota: ");
      double nota = sc.nextDouble();

      for (Aluno aluno : pilhaAlunos) {
        if (aluno.numero == numeroAluno) {
          Nota notaObj = new Nota(numeroAluno, nota);
          filaNotas.add(notaObj);
          System.out.println("Nota cadastrada.");
          break;
        }
      }

      System.out.println("Aluno não cadastrado.");
      return;
  }

  private static void calcularMediaDeAluno(Stack<Aluno> pilhaAlunos, Queue<Nota> filaNotas) {
    if (pilhaAlunos.isEmpty()) {
      System.out.println("Pilha de alunos vazia.");
      return;
    }

    System.out.print("Número do aluno: ");
    int numeroAluno = sc.nextInt();

    for (Aluno aluno : pilhaAlunos) {
      if (aluno.numero == numeroAluno) {
        double somaNotas = 0;
        int quantidadeNotas = 0;

        for (Nota nota : filaNotas) {
          if (nota.numeroAluno == numeroAluno) {
            somaNotas += nota.nota;
            quantidadeNotas++;
          }
        }

        if (quantidadeNotas == 0) {
          System.out.println("Aluno sem notas.");
          return;
        }

        double media = somaNotas / quantidadeNotas;
        System.out.println("Média do aluno = " + media);
      }
    }

    System.out.println("Aluno não cadastrado.");
    return;
  }

  private static void listarAlunosSemNotas(Stack<Aluno> pilhaAlunos, Queue<Nota> filaNotas) {
    if (pilhaAlunos.isEmpty()) {
      System.out.println("Pilha de alunos vazia.");
      return;
    }

    System.out.println("Alunos sem notas:");

    while (!pilhaAlunos.isEmpty()) {
      Aluno aluno = pilhaAlunos.pop();

      
    }
  }
}