class Personne {
    public get nom() : string {
        return this._nom
    }

    public set nom(v : string) {
        this._nom = v;
    }

    public get prenom() : string | undefined {
        return this._prenom
    }

    public set prenom(v : string) {
        this._prenom = v;
    }

    constructor(private _nom: string, private _prenom?: string) { }
}


let maPersonne: Personne = new Personne("Le nom A", "le prénom");
let maPersonne2: Personne = new Personne("Le nom B");

console.log(maPersonne.nom);
console.log(maPersonne2.nom);

maPersonne2.prenom = "Toto";
