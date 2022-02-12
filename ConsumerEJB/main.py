import requests
import json
def main():
    n = 0 
    while(True):
        print("Digite 1 para ADCIONAR uma materia")
        print("Digite 2 para ADCIONAR um Aluno a uma determinada materia")
        print("Digite 3 para REMOVER uma determinada materia")
        print("Digite 4 para OBTER um determinado aluno de uma materia")
        print("Digite 5 para ADCIONAR um Professor a uma determinada materia")
        print("Digite 6 para Obter as informacoes sobre uma determinada materia")
        print("Digite 7 para Obter o nome de todas as materias")
        print("Digite 8 para sair")
        n = int(input())
        if n == 8 :
            break
        if n == 7 :
            r = requests.get("http://localhost:8080/ClientWeb/all")
            print(r.text)
        if n == 6 :
            print("Digite o nome da materia")
            materia = input()
            r = requests.get("http://localhost:8080/ClientWeb/infos/"+materia)
            print(r.text)
        if n== 5 :
            print("Digite o nome do Professor ")
            name = input()
            print("Digite a area do Professor EX: exatas/humanas")
            area = input()
            print("Digite a matricula do Professor ")
            matricula = int(input())
            print("Digite a materia que o Aluno vai estudar")
            materia = input ()
            resp = {
                "materia": materia,
                "matricula": matricula,
                "name": name,
                "area": area
            }
            r = requests.post("http://localhost:8080/ClientWeb/cadrastoprof", data=json.dumps(resp))
            print(r.text)
        if n==4:
            print("Digite o nome da matéria")
            materia = input()
            print("Digite a matricula do Aluno ")
            matricula = int((input())
            r = requests.get("http://localhost:8080/ClientWeb/aluno/"+matricula+"/"+materia)
            print(r.text)            
        if n ==3:
            print("Digite o nome da matéria")
            materia = input()
            payload = {'materia' : materia}
            r = requests.get("http://localhost:8080/ClientWeb/removem/"+materia)
            print(r.text)
        if n ==1 :
            print("Digite o nome da matéria")
            materia = input()
            r = requests.get("http://localhost:8080/ClientWeb/materias/"+materia)
            print(r.text)
        
        if n==2 :
            print("Digite o nome do Aluno ")
            name = input()
            print("Digite o Curso do Aluno ")
            age = input()
            print("Digite a matricula do Aluno ")
            matricula = int(input())
            print("Digite a materia que o Aluno vai estudar")
            materia = input ()
            resp = {
                "materia": materia,
                "matricula": matricula,
                "name": name,
                "curso": age
            }
            r = requests.post("http://localhost:8080/ClientWeb/cadrastoaluno", data=json.dumps(resp))
            print(r.text)

main()
