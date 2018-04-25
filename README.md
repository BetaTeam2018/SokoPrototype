# Prototípus interface-definíciója
* **Első két sor a pálya mérete**  

	`<szélesség>`  
	`<magasság>`  
	
* **Ezután a mezők felsorolása**

	* A switch esetén: `<sorszám> <típus> <súrlódás> <trapdoor sorszáma>` 

* **Minden más mező esetén**: `<sorszám> <típus> <súrlódás>`

* **Majd a  mezők felsorolása, elhelyezése**:

	* Box esetén:
	`<típus> <pozíció>`

	* Player esetén:
	`<típus> <pozíció> <erő>`


**Típuskódok** 

Jelölés | Értelmezés
------------ | -------------
w | wall
a | storage area
s | switch
t | trapdoor
h | hole
p | player
b | box	
O | olajos
N | normál
H | mézes


**Példa** 

Kód | Értelmezés | Megjegyzés
------------ | ------------- | -------------
5 | 5 egység hosszú széles | `x = 5`
1 | 1 egység hosszú magas | `y = 1`  
0 w N | 0. mező egy fal és normál típusú
1 t N 2 | 1. mező egy csapóajtó normáltípusú súrlódás 2 nagyságú
2 s O | 2. mező egy kapcsoló olajjal leöntve
3 f H | 3. mező egy üres mező (padló) mézzel leöntve
4 h N | 4. mező egy lyuk | (5-1). elem tehát ez az utolsó 
p 3 2 | A p játékos (3;1) helyen van és 2 erővel ellátva | `(x;y) = (3;1)`
b 4 | A b doboz (3;1) helyen van

# Bemeneti nyelv 
## A menü parancsai
* `list`        

	>Listázza a pályák neveit (maps könyvtár tartalma).
	
* `load <filename>` 

	>Pálya betöltése és indítása a maps könyvtárban található neve alapján. pl: `maze1.txt`
	
## A játék parancsai
* `step <player> <direction>`  
	> A kiválasztott játékos a megadott irányba lép.  
	
	`<player>` - “p1” vagy “p2”  
	`<direction>` - “up”, “down”, “left”, “right”

* `friction <player> <type>`  
	>A játékos alatti mező súrlódásának módosítása.  
	
	`<player>`  - "p1" vagy "p2"  
	`<type>` - "oil", "honey" vagy "normal"  


* `exit`  

	>Visszalépés a menübe.
	
* `check <x,y>`  

	>Az x,y koordinátán található field és thing attribútumainak listázása.
# Kimeneti nyelv
## Mátrix 

>Minden lépés után a pálya méreteivel megegyező méretű mátrixban látható a játék jelenlegi helyzete.  

### A mátrix elemei   

Jelölés | Értelmezés
------------ | -------------
☺ | első játékos
☻ | második játékos
w | fal  
■ | doboz  
. |  padló  
t | csapóajtó  
h | lyuk  
s | kapcsoló  
a | célhely 

# Tesztek 
## 1. A játékos ládákat tol teszt
### Leírás
> A tesztben egy játékos és három láda vesz részt. A ládák egy sorban helyezkednek el úgy, hogy minden láda után egy üres mező található.  Ha a játékos gyengébb, mint a 3 láda együttes súrlódása, akkor a 3. lépéskor nem történik változás.
### Ellenőrzött funkcionalitás, várható hibahelyek	
> Annak ellenőrzése, hogy a láda eltoláskor valóban tovább megy a mezőre és ha nem tud tovább menni, mert előtte ládák sorakoznak vagy fal gátolja a mozgásban, akkor valóban ne mozduljon el a láda. Ellenőrizzük a több láda eltolására is az előbb említett funkciót.
### Bemenet	
	step p1 right
	step p1 right
	step p1 right
### Elvárt kimenet
```
w☺■.■.■.w  
w.☺■■.■.w  
w..☺■■■.w  
w..☺■■■.w  
```


## 2. Maradj talpon teszt

## 3. A játékos súrlódás miatt meghal

## 4. A játékos ládát tol egy célhelyre, majd letolja róla a ládát

## 5. A játékos ládát tol egy sima mezőre majd egy mézesre

## 6. A játékos minden irányba lépked

## 7. A játékos lyukba esik
