package es.kronox.appofthronesj

// SINGLETON

object CharactersRepo {

    var characters: MutableList<Character> = mutableListOf()     // mutable para usar datos de servidor

    // custom getter, sobreescribiendo el get interno de CharactersRepo
    get() {
        if (field.isEmpty())                                    // Usamos field en lugar de "characters" para evitar volver a entrar en el get recursivamente
            field.addAll(dummyCharacters())

        return field
    }

    private fun dummyCharacters(): MutableList<Character> {

        // Usando Lambda MAP
        val dummies : MutableList<Character> =
            return (1..10).map { index ->                       // Podemos omitir el index
            intToCharacter(index)                               // Map recibe una lambda
        }.toMutableList()
    }

    // Función para buscar personaje dentro de la lista y devolverlo a DetailActivity
    public fun findCharacterById(id: String) : Character? {
        return characters.find { character ->                          // Lambda que devuelve character con id coincidente
            character.id == id
        }
    }

    private fun intToCharacter(int: Int): Character {
        return Character(
            name = "Personaje ${int}",
            title = "Titulo ${int}",
            born = "Nació en ${int}",
            actor = "Actor ${int}",
            quote = "Frase ${int}",
            father = "Padre ${int}",
            mother = "Madre ${int}",
            spouse = "Esposa ${int}",
            house = House(
                name = "Casa ${int}",
                region = "Region ${int}",
                words = "Lema ${int}"
            )
        )

    }
}