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

    private bool ispause=false;

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

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            Application.Quit();

        }else if (Input.GetKeyDown(KeyCode.Return))
        {
            //TODO: LLamar al metodo pause
        }
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

    private void pauseGame()
    {
        //TODO: Lanzar Menu de pausa
    }

    private void reanudeGame()
    {
        //TODO: Reaunudar menu de pausa
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
        for (int i = 2; i >=0 ; i--)
        {
            yield return new WaitForSeconds(1);
            textone.SetText(i.ToString());
            texttwo.SetText(i.ToString());
        }

        players.SetActive(false);

        ball.GetComponent<Ball>().Launch();
    }
}

