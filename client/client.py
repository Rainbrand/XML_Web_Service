import zeep

print("Enter service IP: ")
host = input()
print("Enter service port: ")
port = input()

wsdl = 'http://' + host + ':' + port + '/TextService?wsdl'
client = zeep.Client(wsdl=wsdl)

print("Enter text to send: ")
text = input()
print("List of available commands:\n"
      "1) countOneWord - counts selected word in text,\n"
      "2) countCharacters - count all characters in text,\n"
      "3) countWords - count all words in text,\n"
      "4) makeCaps - make all letters in text capital\n")

while True:
    print("Enter the number of command: ")
    command = input()
    if command == "1":
        print("Enter word to count: ")
        word = input()
        print(client.service.countOneWord(text, word) + '\n')
    elif command == "2":
        print(client.service.countCharacters(text) + '\n')
    elif command == "3":
        print(client.service.countWords(text) + '\n')
    elif command == "4":
        print(client.service.makeCaps(text) + '\n')
