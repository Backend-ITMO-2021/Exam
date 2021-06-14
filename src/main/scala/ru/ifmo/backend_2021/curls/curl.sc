val host = "http://localhost:8080"


val hello = requests.get(host)
hello.text()
val parsePage = requests.get(host)
parsePage.text()

