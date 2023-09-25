using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    private int scoreOne=0, scoreTwo=0;

    [SerializeField]
    private TMP_Text textone, texttwo;

    [SerializeField] private GameObject players;

    [SerializeField]
    private GameObject ball;

    // Instancia estática para ser accedida desde cualquier lugar
    public static GameManager instance;

    void Awake()
    {
        // Comprueba si la instancia ya existe
        if (instance == null)
        {
            // Si no, establece la instancia a esta
            instance = this;
        }
        // Si la instancia ya existe y no es esta:
        else if (instance != this)
        {
            // Entonces destruye este objeto. Esto refuerza nuestro patrón Singleton, lo que significa que solo puede haber una instancia de un GameManager.
            Destroy(gameObject);
        }

        // Establece este para no ser destruido cuando se recargue la escena
        DontDestroyOnLoad(gameObject);
    }

    private void Start()
    {
        StartCoroutine(control());
    }
    public void ScorePlayerOne()
    {
        if (scoreOne < 3)
        {
            scoreOne++;
            textone.SetText(scoreOne.ToString());

            StartCoroutine(restart());
        }
        else
        {
            //TODO: Poner que ha ganado el playerOne (lado izquierdo)
        }
       
    }
    public void ScorePlayerTwo() 
    {
        if (scoreTwo < 3)
        {
            scoreTwo++;
            texttwo.SetText(scoreTwo.ToString());
            StartCoroutine(restart());
        }
        else
        {
            //TODO: Poner que ha ganado el playertwo (lado derecho)
        }


    }
    IEnumerator restart()
    {
        ball.GetComponent<Transform>().SetPositionAndRotation(new Vector3(0, 0, 0), new Quaternion(0, 0, 0, 0));
        ball.GetComponent<Rigidbody2D>().velocity = Vector3.zero;
        yield return new WaitForSeconds(1);
        ball.GetComponent<Ball>().Launch();
        
        
    }
    IEnumerator control()
    {
        
        yield return new WaitForSeconds(1);
        textone.SetText("1");
        texttwo.SetText("1");
        yield return new WaitForSeconds(1);
        textone.SetText("0");
        texttwo.SetText("0");
        //TODO: Añadir controles de jugadores en pantalla.

        players.SetActive(false);

        ball.GetComponent<Ball>().Launch();
    }
}

