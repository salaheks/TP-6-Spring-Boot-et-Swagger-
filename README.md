# Student Management System

Un système de gestion d'étudiants développé avec Spring Boot, JPA, MySQL et Swagger.

## Fonctionnalités

- **CRUD complet** : Créer, lire, mettre à jour et supprimer des étudiants
- **Statistiques** : Compter le nombre total d'étudiants et les grouper par année de naissance
- **API REST** : Endpoints RESTful pour toutes les opérations
- **Documentation automatique** : Interface Swagger pour tester l'API
- **Tests unitaires** : Tests complets avec JUnit 5 et Mockito

## Technologies utilisées

- **Spring Boot 3.5.6** : Framework principal
- **Spring Data JPA** : Persistance des données
- **MySQL** : Base de données
- **Swagger/OpenAPI** : Documentation de l'API
- **JUnit 5** : Tests unitaires
- **Mockito** : Simulation des dépendances

## Structure du projet

```
src/
├── main/
│   ├── java/com/example/student_management/
│   │   ├── controllers/     # Contrôleurs REST
│   │   ├── entities/        # Entités JPA
│   │   ├── repository/      # Repositories
│   │   ├── services/       # Services métier
│   │   └── StudentManagementApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/example/student_management/
        └── StudentControllerTest.java
```

## Configuration

### Base de données MySQL

1. Créer une base de données MySQL :
```sql
CREATE DATABASE studentdb;
```

2. Configurer les paramètres de connexion dans `application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Endpoints API

| Méthode | URL | Description |
|---------|-----|-------------|
| POST | `/students/save` | Créer un nouvel étudiant |
| GET | `/students/all` | Récupérer tous les étudiants |
| DELETE | `/students/delete/{id}` | Supprimer un étudiant |
| GET | `/students/count` | Compter le nombre d'étudiants |
| GET | `/students/byYear` | Statistiques par année de naissance |

## Exemples d'utilisation

### Créer un étudiant
```bash
curl -X POST http://localhost:8080/students/save \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "LACHGAR",
    "prenom": "Mohamed",
    "dateNaissance": "1985-09-01"
  }'
```

### Récupérer tous les étudiants
```bash
curl -X GET http://localhost:8080/students/all
```

### Compter les étudiants
```bash
curl -X GET http://localhost:8080/students/count
```

## Documentation Swagger

Une fois l'application démarrée, accédez à l'interface Swagger :
- **URL** : http://localhost:8080/swagger-ui.html
- **Description** : Interface interactive pour tester tous les endpoints

## Exécution

### Prérequis
- Java 8 ou supérieur
- Maven 3.6+
- MySQL 5.7+

### Démarrer l'application

1. **Via Maven** :
```bash
mvn spring-boot:run
```

2. **Via IDE** :
   - Ouvrir le projet dans votre IDE
   - Exécuter la classe `StudentManagementApplication`

### Tests

Exécuter les tests unitaires :
```bash
mvn test
```

## Exemples de réponses API

### Création d'étudiant (POST /students/save)
```json
{
  "id": 1,
  "nom": "LACHGAR",
  "prenom": "Mohamed",
  "dateNaissance": "1985-09-01"
}
```

### Liste des étudiants (GET /students/all)
```json
[
  {
    "id": 1,
    "nom": "LACHGAR",
    "prenom": "Mohamed",
    "dateNaissance": "1985-09-01"
  }
]
```

### Statistiques par année (GET /students/byYear)
```json
[
  [1985, 2],
  [1990, 1]
]
```

## Codes de statut HTTP

- **201 Created** : Étudiant créé avec succès
- **200 OK** : Opération réussie
- **204 No Content** : Suppression réussie
- **404 Not Found** : Ressource non trouvée

## Architecture

Le projet suit une architecture en couches :

1. **Contrôleurs** : Gestion des requêtes HTTP
2. **Services** : Logique métier
3. **Repositories** : Accès aux données
4. **Entités** : Modèles de données

Cette architecture garantit une séparation claire des responsabilités et facilite la maintenance du code.
