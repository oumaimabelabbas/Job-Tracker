# JobTracker

Application web de suivi des candidatures : on peut consulter la liste de ses candidatures, en ajouter, en supprimer et les filtrer.

## Fonctionnalités

- Afficher la liste des candidatures
- Ajouter une candidature (entreprise, poste, statut, date, notes)
- Supprimer une candidature
- Rechercher et filtrer les candidatures

Chaque candidature contient : `id`, `company`, `position`, `status` (ex. `POSTULE`, `ENTRETIEN`), `appliedDate`, `notes`.

## Stack technique

| Couche | Technologies |
|---|---|
| Backend | Java 17, Spring Boot, Spring Data JPA, API REST |
| Frontend | Angular |
| Base de données | PostgreSQL (dans un conteneur Docker) |
| Tests | JUnit 5, Mockito |

## Architecture

```
Angular (frontend)  ──HTTP/REST──▶  Spring Boot (API)  ──JPA──▶  PostgreSQL (Docker)
```

Le backend suit une architecture en couches : `controller` → `service` → `repository`.


### Prérequis

- Java 17
- Node.js et npm
- Angular CLI
- Docker

## API REST

| Méthode | Endpoint | Description |
|---|---|---|
| GET | `/api/applications` | Liste des candidatures |
| GET | `/api/applications/{id}` | Détail d'une candidature |
| POST | `/api/applications` | Ajouter une candidature |
| DELETE | `/api/applications/{id}` | Supprimer une candidature |
