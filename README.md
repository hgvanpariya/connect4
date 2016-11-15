# connect4
## Synopsis
Connect4 is the gaming server for the game 'Connect4'. In this you can create various Gameboard and create players for the same.
Players can perform the move on specific column. On each move this server will track the winner.
## API Reference

APIs for Players
```
POST /api/v1/connect4/players/
```

```
DELETE /api/v1/connect4/players/{name}
```

```
GET /api/v1/connect4/players/{name}
```

APIs for Gameboards
```
GET /api/v1/connect4/gameboards/{name}
```
```
GET /api/v1/connect4/gameboards/{boardName}/players/{playerName}/column/{columnIndex}
```
```
DELETE /api/v1/connect4/gameboards/{name}
```
```
POST /api/v1/connect4/gameboards/

{
  "allColStatus": [
    0
  ],
  "allPlayers": [
    "string"
  ],
  "boardStatus": [
    [
      0
    ]
  ],
  "col": 0,
  "id": "string",
  "name": "string",
  "row": 0,
  "winner": 0
}
```

```
<servername>/api/v1/connect4/gameboards/<gameboardname>/players/<playername>/column/2
```
